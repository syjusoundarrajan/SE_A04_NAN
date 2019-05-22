import java.io.*;
import java.util.List;

class Image {

	byte[] data;
	int w, h;

	Image( int _w, int _h ) { w = _w; h = _h; data = new byte[w*h*3]; }

	void set( int x, int y, int val ) {
		int offset = (y*w + x) * 3;
		data[offset+0] = (byte)((val & 0x00FF0000) >> 16);
		data[offset+1] = (byte)((val & 0x0000FF00) >>  8);
		data[offset+2] = (byte)((val & 0x000000FF) >>  0);
	}

	void write( String filename ) throws FileNotFoundException,IOException {
		FileOutputStream stream = new FileOutputStream(filename); // +".ppm");
		stream.write(new String("P6 "+w+" "+h+" 255\n").getBytes());
		stream.write(data);
		stream.close();
	}

	void trace( List<Entity> entities ) {

		// TODO: fill me in

	}
}
