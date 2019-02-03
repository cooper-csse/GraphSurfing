import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class AdjacencyMatrixGraph<T> extends Graph<T> {
	Map<T,Integer> keyToIndex;
	List<T> indexToKey;
	int[][] matrix;
	int vertexCount;
	int edgeCount;
	
	AdjacencyMatrixGraph(Set<T> keys) {
		int size = keys.size();
		this.keyToIndex = new HashMap<T,Integer>();
		this.indexToKey = new ArrayList<T>();
		this.matrix = new int[size][size];
		for (T key : keys) {
			this.keyToIndex.put(key, this.vertexCount);
			this.indexToKey.add(key);
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
		if (!this.keyToIndex.containsKey(from)) throw new NoSuchElementException("Did not find 'from' vertex");
		if (!this.keyToIndex.containsKey(to)) throw new NoSuchElementException("Did not find 'to' vertex");
		int fromIndex = this.keyToIndex.get(from), toIndex = this.keyToIndex.get(to);
		if (this.matrix[fromIndex][toIndex] == 0) {
			this.matrix[fromIndex][toIndex] = 1;
			this.edgeCount++;
			return true;
		}
		return false;
	}

	@Override
	public boolean hasVertex(T key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasEdge(T from, T to) throws NoSuchElementException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeEdge(T from, T to) throws NoSuchElementException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int outDegree(T key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int inDegree(T key) {
		// TODO Auto-generated method stub
		return 0;
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
