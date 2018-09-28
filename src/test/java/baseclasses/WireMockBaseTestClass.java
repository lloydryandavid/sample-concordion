package baseclasses;

import org.concordion.api.AfterSpecification;
import org.concordion.api.BeforeSpecification;
import restwebservice.RestWebService;

public class WireMockBaseTestClass extends BaseTestClass {

    private RestWebService webService = new RestWebService();

    @BeforeSpecification
    public void startComponents(){webService.startRestWebService();}

    @AfterSpecification
    public void stopComponents(){webService.stopRestWebService();}

}
