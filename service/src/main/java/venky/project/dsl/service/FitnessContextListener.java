package venky.project.dsl.service;

import com.cerner.beadledom.configuration.ConfigurationSource;
import com.cerner.beadledom.resteasy.ResteasyContextListener;
import com.google.common.collect.Lists;
import com.google.inject.Module;
import java.util.List;
import javax.servlet.ServletContext;

public class FitnessContextListener extends ResteasyContextListener {
  @Override
  protected List<? extends Module> getModules(ServletContext context) {
    return Lists.newArrayList(new FitnessModule(), new ResteasyBootstrapModule());
  }
}
