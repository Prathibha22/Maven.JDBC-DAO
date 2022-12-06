package daos;
import models.DTOCar;
import java.util.Set;

public interface DAOInterface {
    public DTOCar findById(int id);
    Set<DTOCar> findAll();
    public Boolean update(DTOCar dto);
    public Boolean create(DTOCar dto);
    public Boolean delete(int id);
}
