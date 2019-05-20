package com.project.diplom.Model;

import javax.persistence.*;

@Entity(name ="Camera")
@Table(name ="Camera")
public class Camera {
    /**
     * поле индификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "address_ip", length = 50, nullable = false)
    private String address_ip;

    public Camera() {
    }

    public Camera(String name, String address_ip) {
        this.name = name;
        this.address_ip = address_ip;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress_ip() {
        return address_ip;
    }

    public void setAddress_ip(String address_ip) {
        this.address_ip = address_ip;
    }
}
