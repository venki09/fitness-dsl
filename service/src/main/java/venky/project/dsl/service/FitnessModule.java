package venky.project.dsl.service;

import venky.project.dsl.service.resource.HelloWorldResource;
import com.google.inject.PrivateModule;

public class FitnessModule extends PrivateModule {

  protected void configure() {
    bind(HelloWorldResource.class);
    expose(HelloWorldResource.class);
  }
}
