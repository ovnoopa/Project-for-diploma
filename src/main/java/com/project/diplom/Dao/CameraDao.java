package com.project.diplom.Dao;

import com.project.diplom.Model.Camera;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CameraDao {
    /**
     * Получить Camera по идентификатору
     *
     * @param id
     * @return
     */
    Camera loadById(Long id);
    /**
     * Получить Camera(фильтр)
     *
     * @param name
     * @return
     */
    Camera getCameraByName(String name);

    /**
     * Сохраняем данные об Camera
     * @param camera
     */
    void saveCamera(Camera camera);
}
