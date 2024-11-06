package org.plugin;

import org.apache.maven.model.Developer;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.util.List;

@Mojo(name = "infoDevs", defaultPhase = LifecyclePhase.COMPILE)
public class InfoAboutDevelopers extends AbstractMojo {

    @Parameter(defaultValue = "${project}", required = true, readonly = true)
    MavenProject project;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {

        getLog().info("Information about developers:");

        List<Developer> developers = project.getDevelopers();

        if (!developers.isEmpty()) {

            for (Developer developer : developers) {
                getLog().info("ID: " + developer.getId());
                getLog().info("Name: " + developer.getName());
                getLog().info("Roles: " + developer.getRoles());
                getLog().info("Email: " + developer.getEmail());
                getLog().info("URL: " + developer.getUrl());
                getLog().info("Organization: " + developer.getOrganization());
                getLog().info("Organization URL: " + developer.getOrganizationUrl());
                getLog().info("Timezone: " + developer.getTimezone());
                getLog().info("Properties: " + developer.getProperties().toString());
            }
        }
    }
}