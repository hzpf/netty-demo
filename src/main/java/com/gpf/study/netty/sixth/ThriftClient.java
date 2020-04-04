package com.gpf.study.netty.sixth;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class ThriftClient {
    public static void main(String[] args) throws TException {
        TTransport transport = new TFramedTransport(new TSocket("localhost", 8899), 600);
        TProtocol protocol = new TCompactProtocol(transport);
        FuckService.Client client = new FuckService.Client(protocol);

        try {
            transport.open();

            Person person = new Person();
            person.setName("angle");
            client.savePerson(person);
        } finally {
            transport.close();
        }
    }
}
