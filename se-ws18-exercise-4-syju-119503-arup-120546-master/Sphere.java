class Sphere extends Entity {

	Vec3D center;
	float radius;

	Sphere( Vec3D c, float r ) { center = c; radius = r; }

	// https://en.wikipedia.org/wiki/Line%E2%80%93sphere_intersection
	public Vec3D intersect(Vec3D ray) {
		ray = ray.mul(1.0f/ray.len());
		float d1 = center.mul(ray);
		float cl = center.len();
		float d2 = d1*d1 - cl*cl + radius*radius;
		if (d2 < 0.0f) return null;
		// 2nd solution (rear shell): d1 + ...
		float d = d1 - (float)Math.sqrt(d2);
		return ray.mul(d);
	}

}
