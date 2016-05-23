package com.user.commons;

import java.util.ArrayList;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class emailUtility {
	private static final String SMTP_HOST_NAME = "smtp.gmail.com";
	private static final String SMTP_PORT = "465";
	private static final String EMAIL_FROM = "toemyintthuster@gmail.com";
	private static final String EMAIL_FROM_PASSWORD = "";
	private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	private static final String SSL_FACTORY_FALLBACK = "false";
	private static final String SMTP_AUTH = "true";
	private static final String MAIL_DEBUG = "true";

	// constants for Email Address validation.
	private static Pattern pattern;
	private static Matcher matcher;
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public static void sendMail(mailBean mb) throws Exception {
		boolean debug = false;
		int toRecipientsCount = mb.getToRecipients().size(); // get TO
																// recipients
																// count
		int bccRecipientsCount = mb.getBCCRecipients().size(); // get BCC
																// recipients
																// count

		// Validation
		String subject = mb.getMailSubject();
		String message = mb.getMsgContent();

		if (subject.length() <= 0) {
			System.out
					.println("Subject not found for this message. Not able to send such mail.");
			return;
		} else if (message.length() <= 0) {
			System.out
					.println("No message contents found. Not able to send such mail.");
			return;
		} else if (toRecipientsCount == 0 && bccRecipientsCount == 0) {
			System.out
					.println("Message recipients not found. Not able to send such mail./n "
							+ "You should add any one of the following addresses: "
							+ "TO, CC, BCC.");
			return;
		}

		if (mb.getMailFrom().length() > 1) {
			message = message + "/n/n/n" + "---------------------"
					+ "This email is sent onbelfhalf of " + mb.getMailFrom();
		}

		Properties props = new Properties();
		props.put("mail.smtp.host", SMTP_HOST_NAME);
		props.put("mail.smtp.auth", SMTP_AUTH);
		props.put("mail.debug", MAIL_DEBUG);
		props.put("mail.smtp.port", SMTP_PORT);
		props.put("mail.smtp.socketFactory.port", SMTP_PORT);
		props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.put("mail.smtp.socketFactory.fallback", SSL_FACTORY_FALLBACK);

		Session session = null;
		// create a message.
		Message msg = new MimeMessage(session);
		// set the from address.
		InternetAddress addressFrom = new InternetAddress(EMAIL_FROM_PASSWORD);
		msg.setFrom(addressFrom);

		// setting TO addresses - multiple TO addresses will be supported.
		InternetAddress[] toAddresses = new InternetAddress[toRecipientsCount];
		for (int i = 0; i < toRecipientsCount; i++) {
			toAddresses[i] = new InternetAddress(mb.getToRecipients().get(i));
		}
		msg.setRecipients(Message.RecipientType.TO, toAddresses);

		// setting CC addresses - multiple CC addresses will be supported.

		// setting BCC addresses - multiple BCC addresses will be supported.
		if (bccRecipientsCount > 0) {
			InternetAddress[] bccAddresses = new InternetAddress[bccRecipientsCount];

			for (int i = 0; i < bccRecipientsCount; i++) {
				bccAddresses[i] = new InternetAddress(mb.getBCCRecipients()
						.get(i));
			}
			msg.setRecipients(Message.RecipientType.BCC, bccAddresses);
		}

		// Setting the Subject.
		msg.setSubject(subject);
		// Setting message contents.
		msg.setContent(message, "text/plain");

		Transport.send(msg);
	}

	/**
	 * Validating EMail address.
	 **/
	public static Boolean isValidEmail(String emailAdd) {
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(emailAdd);
		return matcher.matches();
	}

	public static void main(String s[]) {
		ArrayList<String> toList = new ArrayList<String>();
		ArrayList<String> bccList = new ArrayList<String>();

		toList.add("spiritbreaker150@gmail.com");

		mailBean mb = new mailBean();
		mb.setMailSubject("Test mail from Java");
		mb.setMsgContent("Testing...");
		mb.setToRecipients(toList);

		mb.setBCCRecipients(bccList);

		try {
			sendMail(mb);
		} catch (Exception e) {
			System.out
					.println("\n\nThere is an error while sending email. Please try again later.\nThe following error occured:");
			e.printStackTrace();
		}
	}
}
