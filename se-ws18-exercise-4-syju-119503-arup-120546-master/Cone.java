class Cone extends Entity {

	Vec3D apex, axis;
	double angle,height;

	public Cone( Vec3D _apex, Vec3D _axis, double _angle, double _height ) {
		apex = _apex;
		axis = _axis.mul(1.0f/_axis.len());
		angle = _angle;
		height = _height;
	}

	// based on http://lousodrome.net/blog/light/2017/01/03/intersection-of-a-ray-and-a-cone/
	public Vec3D intersect( Vec3D ray ) {

		Vec3D d = ray.mul(1.0f/ray.len());
		Vec3D o = new Vec3D(0,0,0);
		Vec3D co = o.sub(apex);

		double dv = d.mul(axis);
		double csq = Math.cos(angle)*Math.cos(angle);
		double cov = co.mul(axis);

		double a = dv*dv - csq;
		double b = 2.0*(dv * cov - d.mul(co) * csq);
		double c = cov*cov - co.mul(co) * csq;
		double delta = b*b - 4.0*a*c;
		if (delta < 0.0) return null;

		// alternative solution: -b - ... = back shell
		double t = (-b + Math.sqrt(delta))/(2.0*a);
		Vec3D p = d.mul((float)t);

		Vec3D dist = p.sub(apex);
		if (dist.len() > height) return null;

		if (dist.mul(axis) < 0) return null;

		return p;
	}

}
