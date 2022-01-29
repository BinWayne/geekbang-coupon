package com.geekbang.coupon.template.dao.convert;

import com.geekbang.coupon.template.api.enums.CouponType;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

@Convert
public class CouponTypeConverter implements AttributeConverter<CouponType, String> {
    @Override
    public String convertToDatabaseColumn(CouponType couponType) {
        return couponType.getCode();
    }

    @Override
    public CouponType convertToEntityAttribute(String s) {
        return CouponType.convert(s);
    }
}
