package gpf.third.sixth;

import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;

public class ThriftServer {
    public static void main(String[] args) throws TTransportException {
        TNonblockingServerSocket serverSocket = new TNonblockingServerSocket(8899);
        THsHaServer.Args arg = new THsHaServer.Args(serverSocket).minWorkerThreads(2).maxWorkerThreads(4);

        FuckService.Processor<FuckServiceImpl> processor = new FuckService.Processor<>(new FuckServiceImpl());
        arg.protocolFactory(new TCompactProtocol.Factory());
        arg.processorFactory(new TProcessorFactory(processor));
        arg.transportFactory(new TFramedTransport.Factory());

        THsHaServer server = new THsHaServer(arg);
        server.serve();
    }
}
