AWS Daemon
==========

This is a daemon project, aimed at allowing better control over projects that run on EC2 instances

Building
--------

To build the project, maven is used. You will need to copy the src/main/resources/AwsCredentials.properties.example file
to src/main/resources/AwsCredentials.properties and edit it to include your AWS credentials.

If forking the project please remember to **NEVER COMMIT** the edited AwsCredentials.properties file.
