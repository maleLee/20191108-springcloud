package com.aaa.lee.springcoud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/9 9:43
 * @Description
 *      springcloud的所有组件就三板斧
 *          创建工程
 *          编写配置
 *          添加注解
 *
 *      eureka的自我保护机制:
 *          如果长时间不连接(不激活)eureka的时候，就会出现自我保护机制，在eureka页面上会显示:
 *              EMERGENCY! EUREKA MAY BE INCORRECTLY CLAIMING INSTANCES ARE UP WHEN THEY'RE NOT. RENEWALS ARE LESSER THAN THRESHOLD AND HENCE THE INSTANCES ARE NOT BEING EXPIRED JUST TO BE SAFE.
 *          为什么会出现自我保护机制呢？
 *              1.长时间不访问，说明eureka用不到，eureka用不到但是仍然会占用资源，eureka会认为自己宕机，保护自己的内部信息资源
 *                      eureka如果认为自己停机，那么说明新的服务就不能向自己注册，但是这个时候一个新的服务可以注册进来，eureka并不知道自己是否处于停机状态
 *                      eureka为了避免发生脏数据，会把认为自己停机之前所注册数据放在一个存储中，把之后所注册数据也放在一个存储空间
 *                      eureka！！认为！！自己死亡，其实没有(需要保护之前的数据)，新的服务注册进来了(本来不应该注册进来，但是仍然注册进来了)
 *                      eureka就会认为该数据为脏数据，如果eureka不重启，则一直会分开存储，一旦eureka重启(自我保护机制失效)，再把两个数据合并
 *             2.网络可能卡顿(网络阻塞)，这就意味着eureka就检测不到provider的心跳(大部分)，假设eureka中一共有200个provider，如果只有3个provider接受不到心跳，eureka就会直接把这三个剔除
 *                  但是如果有180个provider检测不到心跳，eureka就害怕了(网络阻塞，停电...)，eureka就会全部保留
 *
 *             在eureka中所注册过的服务会定时向eureka发送心跳
 *             当网络故障/网络延迟/服务宕机就不会再向eureka发送心跳，eureka从接收不到心跳的那一秒开始计时(90秒)，之后就会直接把这个服务剔除
 *             但是当无法接收大面积的服务心跳的时候，就会全部保留，不再剔除任何一台(eureka的AP性)
 *
 *             3.为什么eureka不会剔除大量的服务？
 *                  如果eureka把所有的服务全部剔除，当consumer进行访问的时候发现eureka中没有任何一个服务，整个项目都必须要处于瘫痪，客户端体验非常差(返回客户端就是404/500)
 *
 *             4.！！！eureka的自我保护机制在真实开发环境中一定不能关闭！！！
 *                  ！！！其实eureka提供了关闭自我保护机制的配置，但是不允许这样做！！
 *                  eureka.server.enable-self-preservation=false
 *                  会在eureka的页面上显示:
 *                      THE SELF PRESERVATION MODE IS TURNED OFF. THIS MAY NOT PROTECT INSTANCE EXPIRY IN CASE OF NETWORK/OTHER PROBLEMS.
 *
 *             5.自我保护机制开启，让其失效
 *                  provider会告诉eureka，我每5秒就会向你发送一次心跳，当最后一次检测我心跳的时间超过8秒还没有接收到心跳直接就把我剔除！
 **/
@SpringBootApplication
@EnableEurekaServer
public class ApplicationRun7081 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun7081.class, args);
    }

}
