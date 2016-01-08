package test;

public class TestToStringRef {
	String name;

	public static void main(String[] args) {
		TestToStringRef ref1 = new TestToStringRef();
		TestToStringRef ref2 = new TestToStringRef();

		System.out.println(ref1 + " & " + ref2);

		callMe(ref1, ref2);
		System.out.println(ref1 + " & " + ref2);
	}

	// references are passed by value
	private static void callMe(TestToStringRef... ref) {

		System.out.println(ref[0] + " & " + ref[1]);
		ref[0] = ref[1];

		ref[1].name = "new";
		System.out.println(ref[0] + " & " + ref[1]);

	}
}
