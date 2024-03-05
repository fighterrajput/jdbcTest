package in.co.rays.test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TestPayment {
	public static void main(String[] args) throws Exception {
		// add();
		// update();
		// delete();
		// search();
		findByPk();
	}

	private static void findByPk() throws Exception {

		PaymentModel model = new PaymentModel();
		PaymentBean bean = model.findByPk(3);
		System.out.print("\t" + bean.getId());
		System.out.print("\t" + bean.getPaymentDate());
		System.out.print("\t" + bean.getDescription());
		System.out.print("\t" + bean.getAmount());
		System.out.print("\t" + bean.getPaymentMethod());
		System.out.print("\t" + bean.getStatus());
		System.out.println("\t" + bean.getPayer());

	}

	private static void search() throws Exception {
		PaymentBean bean = new PaymentBean();
		PaymentModel model = new PaymentModel();
		List list = model.search(bean);
		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (PaymentBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getPaymentDate());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getAmount());
			System.out.print("\t" + bean.getPaymentMethod());
			System.out.println("\t" + bean.getPayer());
		}
	}

	private static void delete() throws Exception {
		PaymentBean bean = new PaymentBean();
		PaymentModel model = new PaymentModel();
		model.delete(4);
	}

	private static void update() throws Exception {
		PaymentBean bean = new PaymentBean();
		bean.setId(3);
		bean.setPaymentDate(new Date());
		bean.setDescription("Electricity");
		bean.setAmount(700);
		bean.setPaymentMethod("UPI");
		bean.setStatus("Successfull");
		bean.setPayer("Rajat");
		PaymentModel model = new PaymentModel();
		model.update(bean);

	}

	private static void add() throws Exception {
		PaymentBean bean = new PaymentBean();
		bean.setId(4);
		bean.setPaymentDate(new Date());
		bean.setDescription("Electricity");
		bean.setAmount(400);
		bean.setPaymentMethod("bank transfer");
		bean.setStatus("Successfull");
		bean.setPayer("Ankit");

		PaymentModel model = new PaymentModel();
		model.add(bean);

	}

}
