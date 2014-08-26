package co.uk.tangentlabs.aws.triggers;

import org.json.JSONObject;

import com.amazonaws.services.ec2.model.Instance;

import co.uk.tangentlabs.aws.EC2Inspector;

public class EC2Trigger implements ITrigger {
    private static String TYPE = "EC2";
    private String name;
    private String instanceID;
    
    public EC2Trigger(String name, JSONObject jsonConfig) {
        this.name = name;
        this.instanceID = jsonConfig.getString("instanceID");
        System.out.println("EC2Trigger created");
    }
    
    public EC2Trigger(String name, JSONObject jsonConfig, Instance instance) {
        this.name = name;
        this.instanceID = jsonConfig.getString("instanceID");
        System.out.println("EC2Trigger created");
    }
    
    public void updateValues() {
    }
    
    @Override
    public String getType() {
        return TYPE;
    }
    
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void checkTrigger() {        
    }
    
    public static void main(String[] args) {
        String testJsonStr = "{'instanceID': '12345'}";
        JSONObject testJson = new JSONObject(testJsonStr);
        EC2Trigger trigger = new EC2Trigger("trigger 1", testJson);
        trigger.getName();
    }
}

/*

{'name': 'trigger one',
 'watchValues': {'instanceTags': ['ExternalIP', 'InternalIP']}
}

*/
