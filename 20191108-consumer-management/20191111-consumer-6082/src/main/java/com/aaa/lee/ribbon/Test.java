package com.aaa.lee.ribbon;

import com.netflix.loadbalancer.ILoadBalancer;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/11 11:50
 * @Description
 **/
public class Test {

    // ILoadBalancer:为了添加或者获取所有的服务列表
    // 在添加服务的时候，会给每一个服务生成一个key值，根据这个key可以获取到该服务(Map(key:value))
    /*public Server choose(ILoadBalancer lb, Object key) {
        // 严谨判断，如果ILoadBalancer为null，说明没有注入成功，获取不到服务列表，所以直接return
        if (lb == null) {
            return null;
        }
        // 标识一个空的服务
        Server server = null;

        // while条件循环，也就是说如果服务在没有选择出来之前一直就在循环，直到服务被选择出来
        while (server == null) {
            // Thread.interrupted():标识线程目前所处于的状态，如果线程的状态为正常则返回true，否则返回false
            // 因为负载均衡解决是高并发的问题，会有很多并发访问，每一个访问就是一个线程，有可能用户访问途中直接离开
            // 用户虽然离开了，但是线程依然在，但是这个线程就会在服务器端呈现被打断的状态(必须要把该线程清出去，return null)
            if (Thread.interrupted()) {
                return null;
            }
            // lb.getReachableServers():获取所有的可用服务列表
            List<Server> upList = lb.getReachableServers();
            // lb.getAllServers():获取所有的服务列表(无论是否可用都被获取到)
            List<Server> allList = lb.getAllServers();

            // 获取到所有的服务数量(无论是否可用):20台provider,serverCount=20
            int serverCount = allList.size();
            // 如果serverCount为0，则没有一个provider
            if (serverCount == 0) {
                *//*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 *//*
                return null;
            }
            // index:就是所有服务中随机出的一个数字
            int index = chooseRandomInt(serverCount);
            // 把随机出的服务编号，放到可用的服务列表中就可以得到一个可用的服务
            server = upList.get(index);

            if (server == null) {
                *//*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 *//*
                // 如果服务为null，说明随机出的服务不可用(宕机)
                *//**
                 * Thread.yield():
                 *      线程谦让(只会存在于多线程中)
                 *      什么叫线程谦让呢？
                 *          当并发的时候，线程和线程之间是互不相让的(线程阻塞)
                 *          一旦线程阻塞容易造成项目雪崩
                 *          在线程互相抢占资源(锁)的时候，就会有一个线程处于等待状态(线程阻塞更严重)
                 *      yield():当手动调用该方法之后
                 *      出现问题的(等待的线程)就会开始谦让，这个线程就会自动被唤醒让线程处于就绪状态，就不会再继续在锁之外等待
                 *      需要重新去抢夺客户端所发送的请求
                 *//*
                Thread.yield();
                // 跳出本次循环进入下一次循环
                continue;
            }
            // isAlive():测试选择出的该服务是否存活
            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            // 说明该服务处于宕机或不可用状态
            server = null;
            Thread.yield();
        }

        return server;

    }

    protected int chooseRandomInt(int serverCount) {
        // nextInt()：随机数的访问(在所有的服务中随机出来一个)
        // 为什么不使用Random？random也是随机数，ThreadLocalRandom也是随机数
        // !!!Random是线程安全的!!!
        // 每一个线程都必须要经过检测之后才可以进行访问，虽然random安全，(当线程比较多的时候)但是random效率非常低(因为线程会进入队列)
        // ThreadLocalRandom:是针对于线程所开发的一个随机数类(有上锁机制)，并且线程不安全(性能不安全)
            // random在所随机出来的数字是可以被预测到的(random有规则)
        // ThreadLocalRandom官方解释:
           // 当项目期望在多线程的环境下运行的时候，如果需要使用到随机数，可以直接用该类，因为该类就是针对于并发所涉及的
            // 和Random和相比ThreadLocalRandom可以减少线程之间的竞争，性能可以达到最优！
        // ThreadLocalRandom:就是在线程中实现随机数
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }*/


}
