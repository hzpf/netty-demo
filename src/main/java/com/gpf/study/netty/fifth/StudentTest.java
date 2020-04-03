package com.gpf.study.netty.fifth;

import com.google.protobuf.InvalidProtocolBufferException;

public class StudentTest {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        StudentOuter.Student student = StudentOuter.Student.newBuilder().setId(123).setName("张三").setEmail("123@qq.com").build();

        StudentOuter.Student student2 = StudentOuter.Student.parseFrom(student.toByteArray());
        System.out.println(student2.getId());
        System.out.println(student2.getName());
        System.out.println(student2.getEmail());
    }
}
