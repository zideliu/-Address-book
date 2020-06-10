package dao;


import dao.jdbc.JDBCUtil;
import entity.Area;
import entity.City;
import entity.Province;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDaoImp implements AddressDao {

	@Override
	public List<Province> getAllProvince() {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			con = JDBCUtil.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from province";	
		List<Province> provinces = new ArrayList<Province>();		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Province province = new Province();
				province.setId(rs.getInt("id"));
				province.setCode(rs.getString("code"));
				province.setName(rs.getString("name"));
				provinces.add(province);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.release(con,ps,rs);
		}
		return provinces;
	}

	@Override
	public List<City> getCityByProvinceCode(String province_code) {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			con = JDBCUtil.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from city where provincecode=?";	
		List<City> cities = new ArrayList<City>();		
		try {
			ps = con.prepareStatement(sql);
			ps.setObject(1, province_code);
			rs = ps.executeQuery();
			while(rs.next()){
				City city = new City();
				city.setId(rs.getInt("id"));
				city.setCode(rs.getString("code"));
				city.setName(rs.getString("name"));
				cities.add(city);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.release(con,ps,rs);
		}
		return cities;
	}

	@Override
	public List<Area> getAreaByCityCode(String city_code) {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			con = JDBCUtil.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from area where citycode=?";	
		List<Area> areas = new ArrayList<Area>();		
		try {
			ps = con.prepareStatement(sql);
			ps.setObject(1, city_code);
			rs = ps.executeQuery();
			while(rs.next()){
				Area area = new Area();
				area.setId(rs.getInt("id"));
				area.setCode(rs.getString("code"));
				area.setName(rs.getString("name"));
				areas.add(area);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.release(con,ps,rs);
		}
		return areas;
	}

}
