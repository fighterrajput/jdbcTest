package in.co.rays.test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

public class PaymentModel {
	PaymentBean bean = new PaymentBean();

	public void add(PaymentBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		PreparedStatement ps = conn.prepareStatement("insert into payment values(?,?,?,?,?,?,?)");
		ps.setInt(1, bean.getId());
		ps.setDate(2, new java.sql.Date(bean.getPaymentDate().getTime()));
		ps.setString(3, bean.getDescription());
		ps.setInt(4, bean.getAmount());
		ps.setString(5, bean.getPaymentMethod());
		ps.setString(6, bean.getStatus());
		ps.setString(7, bean.getPayer());

		int i = ps.executeUpdate();
		System.out.println("data inserted=" + i);

	}

	public void update(PaymentBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		PreparedStatement ps = conn.prepareStatement(
				"update payment set payment_date=? ,description =?, amount =?, payment_method = ?, status=?, payer =? where id=?");
		ps.setDate(1, new java.sql.Date(bean.getPaymentDate().getTime()));
		ps.setString(2, bean.getDescription());
		ps.setInt(3, bean.getAmount());
		ps.setString(4, bean.getPaymentMethod());
		ps.setString(5, bean.getStatus());
		ps.setString(6, bean.getPayer());
		ps.setInt(7, bean.getId());

		int i = ps.executeUpdate();
		System.out.println("data updated=" + i);

	}

	public void delete(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		PreparedStatement ps = conn.prepareStatement("delete from payment where id =?");
		ps.setInt(1, bean.getId());

		int i = ps.executeUpdate();
		System.out.println("data deleted =" + i);
	}

	public List search(PaymentBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select * from payment");

		ResultSet rs = ps.executeQuery();
		List list = new ArrayList();

		while (rs.next()) {
			bean = new PaymentBean();
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getDate(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getInt(4));
			System.out.print("\t" + rs.getString(5));
			System.out.print("\t" + rs.getString(6));
			System.out.println("\t" + rs.getString(7));
			list.add(bean);

		}

		return list;

	}

	public PaymentBean findByPk(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select * from payment where id = ?");

		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		PaymentBean bean = new PaymentBean();

		while (rs.next()) {
			
			System.out.println();
			bean.setId(rs.getInt(1));
			bean.setPaymentDate(rs.getDate(2));
			bean.setDescription(rs.getString(3));
			bean.setAmount(rs.getInt(4));
			bean.setPaymentMethod(rs.getString(5));
			bean.setStatus(rs.getString(6));
			bean.setPayer(rs.getString(7));

		}
		return bean;

	}
}