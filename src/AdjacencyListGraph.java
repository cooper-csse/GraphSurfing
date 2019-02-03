import java.util.*;

public class AdjacencyListGraph<T> extends Graph<T> {
	Map<T,Vertex> keyToVertex;
	int vertexCount;
	int edgeCount;
	
	private class Vertex {
		T key;
		List<T> successorsList;
		List<T> predecessorsList;
		Set<Vertex> successorsSet;
		Set<Vertex> predecessorsSet;
		
		Vertex(T key) {
			this.key = key;
			this.successorsList = new ArrayList<>();
			this.predecessorsList = new ArrayList<>();
			this.successorsSet = new HashSet<>();
			this.predecessorsSet = new HashSet<>();
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
		if (fromVertex.successorsSet.add(toVertex) && toVertex.predecessorsSet.add(fromVertex)) {
			fromVertex.successorsList.add(to);
			toVertex.predecessorsList.add(from);
			this.edgeCount++; return true;
		}
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
		return fromVertex.successorsSet.contains(toVertex);
	}

	@Override
	public boolean removeEdge(T from, T to) throws NoSuchElementException {
		if (!this.keyToVertex.containsKey(from)) throw new NoSuchElementException("Did not find 'from' vertex");
		if (!this.keyToVertex.containsKey(to)) throw new NoSuchElementException("Did not find 'to' vertex");
		Vertex fromVertex = this.keyToVertex.get(from), toVertex = this.keyToVertex.get(to);
		if (fromVertex.successorsSet.remove(toVertex) && toVertex.predecessorsSet.remove(fromVertex)) {
			fromVertex.successorsList.remove(to);
			toVertex.predecessorsList.remove(from);
			this.edgeCount--; return true;
		}
		return false;
	}

	public List<T> getList(T key) {
		return this.keyToVertex.get(key).successorsList;
	}

	@Override
	public int outDegree(T key) throws NoSuchElementException {
		try {
			return this.keyToVertex.get(key).successorsSet.size();
		} catch (NullPointerException e) {
			throw new NoSuchElementException("Did not find 'key' vertex");
		}
	}

	@Override
	public int inDegree(T key) {
		try {
			return this.keyToVertex.get(key).predecessorsSet.size();
		} catch (NullPointerException e) {
			throw new NoSuchElementException("Did not find 'key' vertex");
		}
	}

	@Override
	public Set<T> keySet() {
		return this.keyToVertex.keySet();
	}

	@Override
	public Set<T> successorSet(T key) {
		try {
			Set<T> successors = new HashSet<>();
			for (Vertex edge : this.keyToVertex.get(key).successorsSet) successors.add(edge.key);
			return successors;
		} catch (NullPointerException e) {
			throw new NoSuchElementException("Did not find 'key' vertex");
		}
	}

	@Override
	public Set<T> predecessorSet(T key) {
		try {
			Set<T> predecessors = new HashSet<>();
			for (Vertex edge : this.keyToVertex.get(key).predecessorsSet) predecessors.add(edge.key);
			return predecessors;
		} catch (NullPointerException e) {
			throw new NoSuchElementException("Did not find 'key' vertex");
		}
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
