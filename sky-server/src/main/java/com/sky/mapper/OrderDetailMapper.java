package com.sky.mapper;

import com.sky.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDetailMapper {

    /**
     * 向订单明细表插入n条数据
     * @param orderDetailList
     */
    void insertBatch(List<OrderDetail> orderDetailList);
}
