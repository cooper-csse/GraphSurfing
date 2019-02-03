import java.util.*;

public class AdjacencyListGraph<T> extends Graph<T> {
	Map<T,Vertex> keyToVertex;
	int vertexCount;
	int edgeCount;
	
	private class Vertex {
		T key;
		Set<Vertex> successors;
		Set<Vertex> predecessors;
		
		Vertex(T key) {
			this.key = key;
			this.successors = new HashSet<>();
			this.predecessors = new HashSet<>();
		}
	}
	
	AdjacencyListGraph(Set<T> keys) {
		this.keyToVertex = new HashMap<T,Vertex>();
		for (T key : keys) {
			Vertex v = new Vertex(key);
			this.keyToVertex.put(key, v);
			this.vertexCount++;
		}
	}

	@Override
	public int size() {
		return this.vertexCount;
	}

	@Override
	public int numEdges() {
		return this.edgeCount;
	}

	@Override
	public boolean addEdge(T from, T to) throws NoSuchElementException {
		if (!this.keyToVertex.containsKey(from)) throw new NoSuchElementException("Did not find 'from' vertex");
		if (!this.keyToVertex.containsKey(to)) throw new NoSuchElementException("Did not find 'to' vertex");
		Vertex fromVertex = this.keyToVertex.get(from), toVertex = this.keyToVertex.get(to);
		if (fromVertex.successors.add(toVertex) && toVertex.predecessors.add(fromVertex)) { this.edgeCount++; return true; }
		return false;
	}

	@Override
	public boolean hasVertex(T key) {
		return this.keyToVertex.containsKey(key);
	}

	@Override
	public boolean hasEdge(T from, T to) throws NoSuchElementException {
		if (!this.keyToVertex.containsKey(from)) throw new NoSuchElementException("Did not find 'from' vertex");
		if (!this.keyToVertex.containsKey(to)) throw new NoSuchElementException("Did not find 'to' vertex");
		Vertex fromVertex = this.keyToVertex.get(from), toVertex = this.keyToVertex.get(to);
		return fromVertex.successors.contains(toVertex);
	}

	@Override
	public boolean removeEdge(T from, T to) throws NoSuchElementException {
		if (!this.keyToVertex.containsKey(from)) throw new NoSuchElementException("Did not find 'from' vertex");
		if (!this.keyToVertex.containsKey(to)) throw new NoSuchElementException("Did not find 'to' vertex");
		Vertex fromVertex = this.keyToVertex.get(from), toVertex = this.keyToVertex.get(to);
		if (fromVertex.successors.remove(toVertex) && toVertex.predecessors.remove(fromVertex)) { this.edgeCount--; return true; }
		return false;
	}

	@Override
	public int outDegree(T key) throws NoSuchElementException {
		try {
			return this.keyToVertex.get(key).successors.size();
		} catch (NullPointerException e) {
			throw new NoSuchElementException("Did not find 'key' vertex");
		}
	}

	@Override
	public int inDegree(T key) {
		try {
			return this.keyToVertex.get(key).predecessors.size();
		} catch (NullPointerException e) {
			throw new NoSuchElementException("Did not find 'key' vertex");
		}
	}

	@Override
	public Set<T> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<T> successorSet(T key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<T> predecessorSet(T key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> successorIterator(T key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> predecessorIterator(T key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<T> stronglyConnectedComponent(T key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> shortestPath(T startLabel, T endLabel) {
		// TODO Auto-generated method stub
		return null;
	}

}
