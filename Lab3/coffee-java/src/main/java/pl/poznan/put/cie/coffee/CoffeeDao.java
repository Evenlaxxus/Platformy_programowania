package pl.poznan.put.cie.coffee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

public class CoffeeDao {

	private final NamedParameterJdbcTemplate jdbc;

	public CoffeeDao() {
		// TODO init jdbc using pl.poznan.put.cie.coffee.DbUtilities
		DbUtilities dbUtilities = new DbUtilities();
		DataSource dataSource = DbUtilities.getDataSource("jdbc:sqlserver://localhost:1433;database=Coffees","User1","qwerty");
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.jdbc = namedParameterJdbcTemplate;
		//throw new UnsupportedOperationException("Not implemented yet.");
	}

	/**
	 * Returns a coffee with given name.
	 *
	 * @param name coffee name
	 * @return coffee object or null
	 */
	public Coffee get(String name) {
		String sql = "SELECT sup_id, price, sales, total FROM Coffees "
				+ "WHERE cof_name = :cof_name";
		MapSqlParameterSource params = new MapSqlParameterSource("cof_name", name);
		return jdbc.query(sql, params, new ResultSetExtractor<Coffee>() {

			@Override
			public Coffee extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO implement method #extractData()
				rs.next();
				Coffee e=new Coffee();
				e.setSupplierId(rs.getInt(1));
				e.setPrice(rs.getBigDecimal(2));
				e.setSales(rs.getInt(3));
				e.setTotal(rs.getInt(4));
				return e;
				//throw new UnsupportedOperationException("Not implemented yet.");
			}
		});
	}

	/**
	 * Returns a list of all Coffees.
	 *
	 * @return list of all Coffees
	 */
	public List<Coffee> getAll() {
		String sql = "SELECT cof_name, sup_id, price, sales, total FROM Coffees";
		try {
			// TODO invoke NamedParameterJdbcTemplate.query(String, RowMapper<T>)
			return jdbc.query(sql, new CoffeeRowMapper());
//			throw new UnsupportedOperationException("Not implemented yet.");
		} catch (EmptyResultDataAccessException ex) {
			return new ArrayList<>();
		}
	}

	public class CoffeeRowMapper implements RowMapper<Coffee>{
		@Override
		public Coffee mapRow(ResultSet rs, int i) throws SQLException{
			Coffee c = new Coffee();
			c.setName(rs.getString(1));
			c.setSupplierId(rs.getInt(2));
			c.setPrice(rs.getBigDecimal(3));
			c.setSales(rs.getInt(4));
			c.setTotal(rs.getInt(5));
			return c;
		}
	}

	public void update(Coffee c) {
		String sql = "UPDATE Coffees "
				+ "SET price = :price, sales = :sales, total = :total "
				+ "WHERE cof_name = :cof_name AND sup_id = :sup_id";
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("price", c.getPrice());
		parameters.put("sales", c.getSales());
		parameters.put("total", c.getTotal());
		parameters.put("cof_name", c.getName());
		parameters.put("sup_id", c.getSupplierId());
		jdbc.update(sql, parameters);
	}

	public void delete(String name, int supplierId) {
		// TODO implement method CoffeeDao#delete(), use NamedParameterJdbcTemplate.update(String, Map)
		// DELETE FROM Coffees WHERE cof_name = ? AND sup_id = ?
		String sql = "DELETE FROM Coffees "
				+ "WHERE cof_name = :cof_name " + "AND sup_id = :sup_id";
		MapSqlParameterSource params = new MapSqlParameterSource("cof_name", name);
		params.addValue("sup_id", supplierId);
		jdbc.update(sql,params);
		//throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void create(Coffee c) {
		// TODO implement method CoffeeDao#create(), use NamedParameterJdbcTemplate.update(String, Map)
		// INSERT INTO Coffees(cof_name, sup_id, price, sales, total) VALUES(?, ?, ?, ?, ?)
		String sql = "INSERT INTO Coffees(cof_name, sup_id, price, sales, total) VALUES(:cof_name, :sup_id, :price, :sales, :total)";
		MapSqlParameterSource params = new MapSqlParameterSource("cof_name", c.getName());
		params.addValue("sup_id", c.getSupplierId());
		params.addValue("price", c.getPrice());
		params.addValue("sales", c.getSales());
		params.addValue("total", c.getTotal());
		jdbc.update(sql,params);

		//throw new UnsupportedOperationException("Not implemented yet.");
	}

}
