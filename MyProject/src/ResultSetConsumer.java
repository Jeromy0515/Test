import java.sql.ResultSet;

public interface ResultSetConsumer<T> {
	public T consume (ResultSet rs);
	
}
