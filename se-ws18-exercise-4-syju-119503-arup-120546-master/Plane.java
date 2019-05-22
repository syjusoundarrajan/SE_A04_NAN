class Plane extends Entity {

	Vec3D point,normal;

	Plane( Vec3D p, Vec3D n ) { point = p; normal = n; }

	// https://en.wikipedia.org/wiki/Line%E2%80%93plane_intersection
	public Vec3D intersect(Vec3D ray) { 
		float d1 = point.mul(normal);
		float d2 = ray.mul(normal);
		if (d2 == 0.0) return null;
		return ray.mul(d1/d2);
	}

}
