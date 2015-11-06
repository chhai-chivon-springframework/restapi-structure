package com.gazatem.java.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    final private ShopRepository shopRepository;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    public List<Shop> findAll() {
        return shopRepository.findAll();
    }
/*

    @Override
    @Transactional
    public Shop create(Shop shop) {
        Shop createdShop = shop;
        return shopRepository.save(createdShop);
    }

    @Override
    @Transactional
    public Shop findById(Long id) {
        return shopRepository.findOne(id);
    }

    @Override
    //@Transactional(rollbackFor=ShopNotFound.class)
    @Transactional()
    public Shop delete(Long id){
        Shop deletedShop = shopRepository.findOne(id);
        return deletedShop;
    }
*/



/*    @Override
    @Transactional()
    public Shop update(Shop shop){
        Shop updatedShop = shopRepository.findOne(shop.getId());
        updatedShop.setName(shop.getName());
        updatedShop.setEmplNumber(shop.getEmplNumber());
        return updatedShop;
    }*/
}
