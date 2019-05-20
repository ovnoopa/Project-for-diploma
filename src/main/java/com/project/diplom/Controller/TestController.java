package com.project.diplom.Controller;

import com.project.diplom.Dao.CameraDao;
import com.project.diplom.Service.CameraService;
import com.project.diplom.View.CameraView;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/", produces = APPLICATION_JSON_VALUE)
public class TestController {

    private final CameraService cameraService;


    @Autowired
    public TestController(CameraService cameraService) {
        this.cameraService = cameraService;
    }

    @ApiOperation(value = "Добавить новую камеру", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/camera")
    public void camera(@RequestBody CameraView cameraView) {
        cameraService.addCamera(cameraView);
    }

    @ApiOperation(value = "Получить ping", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 400, message = "Not found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    @GetMapping("/ping")
    public ResponseEntity<StreamingResponseBody> handleRequest(CameraView cameraView){
        return cameraService.handleRequest(cameraView);
    }




}
