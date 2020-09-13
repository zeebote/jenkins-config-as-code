# Jenkins configuration as code
This jenkins configuration as code is using **CasC** plugin and **Jobdsl** plugin to create Jenkins job based on groovy script.<br> 
When CasC loads the jenkins.yaml configuration file, it will create the **seed-all** job which is triggered to run on schedule every 2 minutes. 
However, at the 1st run, the **seed-all** job will overwrite itself with the new trigger when a change is pushed to github, rather than a scheduled timer; it also create all other jenkins jobs through groovy files in this repo by the seed-all.goovy script. Any new groovy file added to repo with correct formatting will trigger the **seed-all** job run and this will in turn add the new job to jenkins. <br>
This configuration assumse you already have CasC, jobDSL, Github plugin installed on your jenkins. You also have already configured web hook trigger from Gitbub to your Jenkins master.<br>
To apply this configuration:
1. Go to Manage Jenkins
1. Click on Configuration as Code
1. In Replace the Configuration Source with: copy the raw URL from jenkins.yaml to the box Path or URL 
1. Apply new configuration.

Watch your jenkins for the **seed-all** job run (2 minutes after applying this config) and create a freestyle job and a pipeline job.<br>
Testing job trigger by copying either freestyle.groovy or pipeline.groovy, rename the job title then commit to your repo with new filename.groovy and watch the **seed-all** job run and create new jenkins job.
