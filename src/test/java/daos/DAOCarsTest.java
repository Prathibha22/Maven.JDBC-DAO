package daos;

import com.sun.xml.internal.ws.client.BindingProviderProperties;
import junit.framework.Assert;
import junit.framework.TestCase;
import models.DTOCar;

import java.util.Set;

public class DAOCarsTest extends TestCase {

    public void testFindById() {
        //given
        String expectedName="TOYOTA";
        String expectedYear="2011";
        String expectedColor="BLACK";
        String expectedModel="CAMRY";
        //When
        DAOCars objCars=new DAOCars();
       //  objCar=new DTOCar();
        DTOCar objCar=objCars.findById(1);
        //Then
        Assert.assertEquals(expectedName,objCar.get_name());
        Assert.assertEquals(expectedColor,objCar.get_color());
        Assert.assertEquals(expectedModel,objCar.get_make());
        Assert.assertEquals(expectedColor,objCar.get_color());

    }

    public void testFindAll() {
        //given
        int expectedCount=5;
        //When
        DAOCars objCars=new DAOCars();
        Set actualCars=objCars.findAll();
        Assert.assertEquals(expectedCount,actualCars.size());
    }

    public void testCreate() {
        //GIven
        DTOCar objCar=new DTOCar();
        objCar.set_name("toyota");
        objCar.set_make("carola");
        objCar.set_color("black");
        objCar.set_year("2022");
        //when
        DAOCars objCars=new DAOCars();
       Boolean actual= objCars.create(objCar);
        Assert.assertTrue(actual);
    }

    public void testUpdate() {
        //GIven
        DTOCar objCar=new DTOCar();
        objCar.set_name("toyotaTest");
        objCar.set_make("carola");
        objCar.set_color("red");
        objCar.set_year("2023");
        objCar.set_id(6);
        //when
        DAOCars objCars=new DAOCars();
        Boolean actual= objCars.update(objCar);
        Assert.assertTrue(actual);

    }

    public void testDelete() {
        //Given
        DAOCars objCars=new DAOCars();
        //When
        Boolean actual= objCars.delete(5);
        //Then
        Assert.assertTrue(actual);

    }
}