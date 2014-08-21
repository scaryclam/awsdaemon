package co.uk.tangentlabs.aws;

import java.util.List;

import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.Reservation;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;

public class EC2Inspector {
	/* This is the EC2 inspector. It uses the AWS API to have a look at and record information about
	 * the other instances on the same project
	 */
	private static final AWSCredentialsProvider CREDENTIALS_PROVIDER =
			new ClasspathPropertiesFileCredentialsProvider();
	
	private static final Region REGION = Region.getRegion(Regions.EU_WEST_1);
	
	public EC2Inspector() {
		System.out.println("Creating new inspector");
		AmazonEC2Client ec2client = new AmazonEC2Client(CREDENTIALS_PROVIDER);
		ec2client.setRegion(REGION);
		DescribeInstancesResult result = ec2client.describeInstances();
		List <Reservation> reservationList  = result.getReservations();
		for (Reservation res:reservationList) {
			List <Instance> instanceList = res.getInstances();
			for (Instance instance:instanceList) {
				System.out.println("\n----------------------");
				System.out.println("Instance IP: " + instance.getPublicIpAddress());
				System.out.println("Instance ID: " + instance.getInstanceId());
				System.out.println("Instance Name: " + instance.getKeyName());
				System.out.println("----------------------\n");
			}
		}
		System.out.println("Finished");
	}

    public static void main(String[] args) {
    	EC2Inspector ec2Inspector = new EC2Inspector();
    }
}
