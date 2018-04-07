package venky.project.dsl.service;

import venky.project.dsl.service.resource.NutritionResource;
import com.google.inject.PrivateModule;

public class FitnessModule extends PrivateModule {

  protected void configure() {
    bind(NutritionResource.class);
    expose(NutritionResource.class);
  }
}
