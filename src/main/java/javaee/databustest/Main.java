package javaee.databustest;

import com.ccic.databus.client.publish.DataBusPublishClient;

public class Main {
    public static void main(String[] args) {
        DataBusPublishClient client = DataBusPublishClientSingleton
                .getInstance("mongodb://10.2.3.153:27087,10.2.3.174:27087,10.2.3.227:27087/databus_v5real");
        try {
            client.send("AML_wtlstActiveStatus", "BML", "234567", "<a>a<a>");
        } catch (Exception e) {

        }
    }
}
