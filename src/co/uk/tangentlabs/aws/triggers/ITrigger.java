package co.uk.tangentlabs.aws.triggers;

public interface ITrigger {
    public void checkTrigger();
    public String getType();
    public String getName();
}
