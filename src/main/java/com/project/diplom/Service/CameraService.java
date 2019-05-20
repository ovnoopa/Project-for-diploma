package com.project.diplom.Service;

import com.project.diplom.Model.Camera;
import com.project.diplom.View.CameraView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

public interface CameraService {
    void addCamera(CameraView cameraView);
    String getCameraIp(CameraView cameraView);
    ResponseEntity<StreamingResponseBody> handleRequest(CameraView cameraView);
}
