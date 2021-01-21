import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlExam {
	
		String url = "jdbc:mysql://localhost/mysql?serverTimezone=UTC";
		String user = "root";
		String passwd = "1234";

	public <T> List<T> select(String query, ResultSetConsumer<T> consumer){
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		List<T> result = new ArrayList<T>();
		try {
			con = DriverManager.getConnection(url,user,passwd);
			st = con.createStatement();

			rs = st.executeQuery(query);
			while(rs.next()) {
				result.add(consumer.consume(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)
					rs.close();
				if(st != null)
					st.close();
				if(con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	SqlExam() {
		
		List<String> list = select("select user from user", new ResultSetConsumer<String>() {
			@Override
			public String consume(ResultSet rs) {
				try {
					return rs.getString("user");
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}
		});
			
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
	}
	
	public static void main(String[] args) {
		new SqlExam();
	}
}
