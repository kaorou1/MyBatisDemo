package com.kaorou.mybatis.mapper;

import com.kaorou.mybatis.entity.Order;

import java.util.List;

public interface OrderMapper {

    List<Order> selectAllOrder();
}
