package com.geekbang.coupon.template.service;

import com.geekbang.coupon.template.api.beans.rules.Discount;
import com.geekbang.coupon.template.api.beans.rules.TemplateRule;
import com.geekbang.coupon.template.api.enums.CouponType;
import com.geekbang.coupon.template.dao.entity.CouponTemplate;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;


public class CouponTemplateServiceImplTest extends AbstractTest{

    @Test
    public void testInsert(){
        Discount discount = Discount.builder()
                .quota(Long.valueOf(22))
                .threshold(Long.valueOf(22)).build();
        TemplateRule rule = TemplateRule.builder()
                .deadline(Long.valueOf(111))
                .discount(discount)
                .limitation(Integer.valueOf(2))
                .build();
        CouponTemplate template = CouponTemplate.builder()
                .available(true)
                .category(CouponType.DISCOUNT)
                .description("desc")
                .name("test")
                .rule(rule)
                .shopId(Long.valueOf(22))
                .build();
        service.saveCouponTemplate(template);

    }

}
