package Core;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.qameta.allure.Allure;

public class AttachFiles {
	public static void attachCsv(String filePath, String fileName) throws IOException {
		byte[] array = Files.readAllBytes(Paths.get(filePath));
		ByteArrayOutputStream attachmentContent = new ByteArrayOutputStream();
		attachmentContent.write(array);

		Allure.addAttachment(fileName, "text/csv", new ByteArrayInputStream(attachmentContent.toByteArray()), ".csv");
	}
}