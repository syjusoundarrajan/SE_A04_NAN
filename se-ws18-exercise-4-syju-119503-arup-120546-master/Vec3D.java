class Vec3D {

	public float x,y,z;
	Vec3D( float _x, float _y, float _z ) { x = _x; y =_y; z = _z; }

	Vec3D( String _s ) {
		String[] items = _s.split("\\s+");
		x = Float.parseFloat(items[1]);
		y = Float.parseFloat(items[2]);
		z = Float.parseFloat(items[3]);
	}

	public String toString() { return "[ " + x + " " + y + " " + z + " ]"; }
	
	Vec3D add( Vec3D other ) { return new Vec3D( x+other.x, y+other.y, z+other.z ); }
	Vec3D sub( Vec3D other ) { return new Vec3D( x-other.x, y-other.y, z-other.z ); }

	Vec3D mul( float other ) { return new Vec3D( x*other, y*other, z*other ); }
	float mul( Vec3D other ) { return x*other.x + y*other.y + z*other.z; }

	float len() { return (float)Math.sqrt( x*x + y*y + z*z ); }

	Vec3D cross( Vec3D other ) { return new Vec3D(
		y*other.z - z*other.y,
		z*other.x - x*other.z,
		x*other.y - y*other.x
	); }
}
