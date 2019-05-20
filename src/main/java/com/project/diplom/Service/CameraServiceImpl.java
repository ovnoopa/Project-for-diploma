package com.project.diplom.Service;

import com.project.diplom.Dao.CameraDao;
import com.project.diplom.Model.Camera;
import com.project.diplom.View.CameraView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Service
public class CameraServiceImpl implements CameraService {
    private final CameraDao dao;
    private String address_ip;

    @Autowired
    public CameraServiceImpl(CameraDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public void addCamera(CameraView cameraView) {
        Camera camera = new Camera(cameraView.name, cameraView.address_ip);

    }


    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<StreamingResponseBody> handleRequest(CameraView cameraView) {
        {

            StreamingResponseBody responseBody = out -> {

                Process p = Runtime.getRuntime().exec("ping " + getCameraIp(cameraView));
                //Process p = Runtime.getRuntime().exec("ping -t google.com");
                InputStreamReader in = new InputStreamReader(p.getInputStream(), "866");
                //String code = in.getEncoding();
                BufferedReader inputStream = new BufferedReader(in);

                String time = "";
                int beginIndex;
                int endIndex;
                time = inputStream.readLine();

                while ((time != null)) {
                    if (time.length() > 0 && time.contains("время")) {
                        beginIndex = time.indexOf("время");
                        endIndex = time.indexOf("TTL");
                        time = time.substring(beginIndex, endIndex);
                        if(time.contains("время"))
                        {
                            beginIndex = time.indexOf("=") + 1;
                            endIndex = time.indexOf("мс");
                            time = time.substring(beginIndex, endIndex);
                        }
                    }

                    //inputLine = inputStream.readLine();
                    time = inputStream.readLine();
                    //out.write(inputLine.getBytes());
                    out.write(time.getBytes(StandardCharsets.UTF_8));
                    out.flush();
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };

            return new ResponseEntity(responseBody, HttpStatus.OK);
        }
    }

    @Override
    public String getCameraIp(CameraView cameraView) {
        Camera camera = dao.getCameraByName(cameraView.name);
        String address_ip = camera.getAddress_ip();
        return  address_ip;
    }
}
