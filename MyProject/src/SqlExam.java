import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SqlExam {
	
	static Connection connection = null;
	
	static {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mysql?serverTimezone=UTC","root","1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public <T> List<T> select(String sql, ResultSetConsumer<T> consumer){
		ResultSet rs = null;
		List<T> result = new ArrayList<T>();
		try (PreparedStatement pst = connection.prepareStatement(sql)){
			rs = pst.executeQuery();
			while(rs.next()) {
				result.add(consumer.consume(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	SqlExam() {
		
		
		List<String> list = select("select * from tbl_bus", e -> {
			try {
				return e.getString("user");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			return null;
		});
			
		func(list);
	}
	
	private <T> void func(List<T> list) {
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
	
	
	public static void main(String[] args) {
		new SqlExam();
	}
}
