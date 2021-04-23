package com.example.demo.rest;

import java.util.*;
import com.example.demo.dao.ShopsDAO;
import com.example.demo.dao.PicturesDAO;
import com.example.demo.models.Picture;
import com.example.demo.models.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shops")
public class ControllerRest {

    @Autowired
    private ShopsDAO shopsDAO;
    @Autowired
    private PicturesDAO picturesDAO;

    @GetMapping
    public ResponseEntity<List<Shop>> getProducto() {
        List<Shop> shops = shopsDAO.findAll();
        return ResponseEntity.ok(shops);
        //return null;
    }

    @GetMapping(value="/{shopId}/pictures")
    public ResponseEntity<List<Picture>> getShopPictures(@PathVariable("shopId") Long shopId) {
        List<Picture> pictures = picturesDAO.findPicturesByShopId(shopId);
        return ResponseEntity.ok(pictures);
    }

    @PostMapping
    public ResponseEntity<Shop> crearShop(@RequestBody Shop shop) {
        Shop newShop = shopsDAO.save(shop);
        return ResponseEntity.ok(newShop);
    }

    @PostMapping(value="/{shopId}/pictures")
    public ResponseEntity<Picture> crearPicture(@RequestBody Picture picture, @PathVariable("shopId") Long shopId) {
        picture.setShopId(shopId);
        Picture newPicture = picturesDAO.save(picture);
        return ResponseEntity.ok(newPicture);
    }

    @DeleteMapping(value="/{shopId}")
    public ResponseEntity<Void> deleteShop(@PathVariable("shopId") Long shopId) {
        shopsDAO.deleteById(shopId);
        return ResponseEntity.ok(null);
    }

    @Transactional
    @DeleteMapping(value="/{shopId}/pictures")
    public ResponseEntity<Void> deleteShopPictures(@PathVariable("shopId") Long shopId) {
        picturesDAO.deletePicturesByShopId(shopId);
        return ResponseEntity.ok(null);
    }

    @PutMapping
    public ResponseEntity<Shop> updateShop(@RequestBody Shop shop) {
        Optional<Shop> optionalShop = shopsDAO.findById(shop.getId());
        if (optionalShop.isPresent()) {
            Shop updateShop = optionalShop.get();
            updateShop.setName(shop.getName());
            shopsDAO.save(updateShop);
            return ResponseEntity.ok(updateShop);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value="/{shopId}")
    public ResponseEntity<Shop> getShopById(@PathVariable("shopId") Long shopId) {
        Optional<Shop> optionalShop = shopsDAO.findById(shopId);
        if (optionalShop.isPresent()) {
            return ResponseEntity.ok(optionalShop.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
