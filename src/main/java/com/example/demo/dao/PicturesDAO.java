package com.example.demo.dao;

import com.example.demo.models.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PicturesDAO extends JpaRepository<Picture, Long> {

    List<Picture> findPicturesByShopId(Long shopId);

    void deletePicturesByShopId(Long shopId);
}