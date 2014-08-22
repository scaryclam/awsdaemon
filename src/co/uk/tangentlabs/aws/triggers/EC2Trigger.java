package co.uk.tangentlabs.aws.triggers;

public class EC2Trigger implements ITrigger {
    private static String TYPE = "EC2";
    private String name;
    private String instanceID;
    
    public EC2Trigger(String name, String instanceID) {
        this.name = name;
        this.instanceID = instanceID;
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
}

/*

{'name': 'trigger one',
 'watchValues': {'instanceTags': ['ExternalIP', 'InternalIP']}
}

*/
