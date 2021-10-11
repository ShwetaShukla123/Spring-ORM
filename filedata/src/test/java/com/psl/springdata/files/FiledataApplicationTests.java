package com.psl.springdata.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.psl.springdata.files.entities.Image;
import com.psl.springdata.files.repos.ImageRepository;

@SpringBootTest
class FiledataApplicationTests {

	@Autowired
	ImageRepository repository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testImageSave() {
		Image image = new Image();
		image.setId(1);
		image.setName("springboot.jpg");

		File file = new File("C:\\Users\\shweta_shukla1\\Documents\\images\\springbootimage.jpg");

		byte fileContent[] = new byte[(int) file.length()];
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			fileInputStream.read(fileContent);

			image.setData(fileContent);
			repository.save(image);
			fileInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testReadImage() {
		Image image = repository.findById(1L).get();
		File file = new File("C:\\Users\\shweta_shukla1\\Documents\\images\\downloadedimages\\" + image.getName());
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			fos.write(image.getData());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
