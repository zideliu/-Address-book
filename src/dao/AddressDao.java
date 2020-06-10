package dao;
import entity.Area;
import entity.City;
import entity.Province;

import java.util.List;


public interface AddressDao {
	List<Province> getAllProvince();
	List<City> getCityByProvinceCode(String province_code);
	List<Area> getAreaByCityCode(String city_code);
}
