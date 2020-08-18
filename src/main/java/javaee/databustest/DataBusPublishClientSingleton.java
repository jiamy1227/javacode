package javaee.databustest;

import com.ccic.databus.client.publish.DataBusPublishClient;

/**
 * @Author: Ding
 * @Date: 2019/8/17 17:53
 */
public class DataBusPublishClientSingleton {

    private static volatile DataBusPublishClient dataBusPublishClient =null;
    private DataBusPublishClientSingleton(){}

    public static DataBusPublishClient getInstance(String DATABUS_URL){
        //生产环境
     //String DATABUS_URL = "mongodb://10.1.88.68:27067,10.1.88.69:27067/databus_v5real";
        //测试环境
     //String DATABUS_URL = "mongodb://10.1.12.122:27047,10.1.12.123:7027/databus_v5real";
        if(null ==dataBusPublishClient){
            synchronized (DataBusPublishClientSingleton.class){
                if(null==dataBusPublishClient){
                    dataBusPublishClient = new DataBusPublishClient(DATABUS_URL, null, null);
                    dataBusPublishClient.init();
                }
            }
        }
        return  dataBusPublishClient;
    }
}
