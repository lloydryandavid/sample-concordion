package baseclasses;

import library.LibraryApplication;
import org.concordion.api.AfterSpecification;
import org.concordion.api.BeforeSpecification;

public class LibraryBaseTestClass extends BaseTestClass {


    @BeforeSpecification
    public void startComponents(){
        LibraryApplication.main(new String[]{});}

}
