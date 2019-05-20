package com.project.diplom.View;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CameraView {
    @NotEmpty
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public String id;

    @Size(max = 50)
    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "Имя", example = "Camera1")
    public String name;

    @Size(max = 50)
    @NotEmpty(message = "address_ip cannot be null")
    @ApiModelProperty(value = "IP адрес камеры", example = "192.198.1.1")
    public String address_ip;

    @Override
    public String toString() {
        return "CameraView{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address_ip='" + address_ip + '\'' +
                '}';
    }
}
