package com.gpf.study.netty.sixth;

public class FuckServiceImpl implements FuckService.Iface {

    @Override
    public void savePerson(Person person) {
        System.out.println(person.getName());
    }
}
