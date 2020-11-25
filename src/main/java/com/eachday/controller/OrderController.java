package com.eachday.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class OrderController {

    public static void main(String[] args) {
//        System.out.println(OrderStatus.waitOrder.name());
//        System.out.println(betweenTwoTime(getDayStart(),LocalDateTime.now(),ChronoUnit.YEARS));;
        System.out.println(new OrderController().getClass().getName());
    }





    enum OrderStatus{
        waitOrder(0,"待接单"),
        waitCharge(1,"待支付预付款");

        private int code;
        private String desc;

        OrderStatus(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }
    }

    public static long betweenTwoTime(LocalDateTime startTime, LocalDateTime endTime, ChronoUnit field) {
        System.out.println(LocalDate.from(getDayStart() )+"========"+ LocalDate.from(LocalDateTime.now()));
        Period period = Period.between(LocalDate.from(startTime), LocalDate.from(endTime));
        System.out.println(period.getMonths());
        if (field == ChronoUnit.YEARS) return period.getYears();
        if (field == ChronoUnit.MONTHS) return period.getYears() * 12 + period.getMonths();
        return field.between(startTime, endTime);
    }
    public static LocalDateTime getDayStart() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.parse("2019-06-28 17:07:05",df);
        return ldt;
    }
}
